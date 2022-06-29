<template>
  <div>
    <div id="target">
      <iv-input
        v-model="inputComment"
        type="textarea"
        :rows="3"
        :placeholder="placeholders">
      </iv-input>
      <div style="text-align: right;margin-top: 10px">
        <iv-button @click="cancel" style="margin-right: 10px">取消</iv-button>
        <iv-button type="primary" round @click="commitComment">确定</iv-button>
      </div>
    </div>

    <List item-layout="vertical" size="small" :split="false">
      <ListItem v-for="item in commentList" :key="item.id">
        <li style="margin-left: 0px;" v-show="item !== '' || item.content !== null" @click="showCommentInput(comment,item)">
          <span style="color: #2d9aff">{{ item.nickname }} </span>：{{ item.content }}
          <a style="margin-left: 30px;"><Icon type="ios-chatbubbles-outline"/>回复</a>
        </li>
<!--          <li>
            <Icon type="ios-calendar-outline"/>
            {{item.createTime}}
          </li>-->
        <div v-if="item.replyComments" class='commentSecond'>
          <Reply :replyComment="item.replyComments" :comment='item' v-on:showCommentInput="showCommentInput"></Reply>
        </div>
      </ListItem>
    </List>

  </div>
</template>

<script>

import Reply from './Reply'

export default {
  components: {
    Reply
  },
  name: 'Comment',
  props: {
    commentList: Array,
    postId: Number
  },
  data () {
    return {
      inputComment: '', // 评论内容
      placeholders: '写下你的评论', // 输入框默认内容
      commentModal: false // 登录提示
    }
  },
  methods: {
    /**
     * 点击取消按钮
     */
    cancel () {
      this.inputComment = ''
      this.placeholders = '写下你的评论'
      this.fromId = null
    },
    /**
     * 提交评论
     */
    async commitComment () {
      const manager = JSON.parse(localStorage.getItem('currentManager'))
      var nickname = ''
      var byManagerId = null
      if (manager) {
        nickname = manager.name
        byManagerId = manager.id
        this.commitComment2(nickname, byManagerId)
      } else {
        this.$Modal.confirm({
          title: '您尚未登录',
          content: '游客评论将生成随机用户名',
          onOk: () => {
            nickname = '游客' + new Date().getTime()
            this.commitComment2(nickname, byManagerId)
          }
        })
      }
    },

    commitComment2 (nickname, byManagerId) {
      if (!this.inputComment.trim()) {
        this.$Message.warning('评论信息不能为空！')
      } else {
        const comment = {
          nickname: nickname,
          content: this.inputComment,
          articleId: this.postId,
          byManagerId: byManagerId,
          pid: this.fromId
        }
        this.$http({
          url: this.$http.adornUrl('/comment/save'),
          method: 'post',
          data: this.$https.adornDatas(comment)
        }).then(({data}) => {
          if (data.result.status === -1) {
            this.$Message.error(data.result.error)
          } else {
            this.$Message.success('评论成功')
            this.$emit('on-comment', this.postId)
          }
        })
      }
      this.placeholders = '写下你的评论'
      this.inputComment = ''
    },
    /**
     * 点击评论按钮显示输入框
     * item: 当前大评论
     * reply: 当前回复的评论
     */
    showCommentInput (item, reply) {
      if (reply) {
        this.placeholders = '@' + reply.nickname + ' '
      } else {
        this.inputComment = ''
      }
      // 当点击了回复时，页面滚动到评论框的位置
      document.getElementById('target').scrollIntoView()
      this.fromId = reply.id
    }
  }
}

</script>

<style scoped>
.commentSecond {
  /*padding: 2px;*/
  /* background-color: #EAEAEC;*/
  border-radius: 5px;
  margin: 2px 10px;
}

list, listitem {
  display: block;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>
