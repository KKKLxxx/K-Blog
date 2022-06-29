<template>
  <div>
    <List item-layout="vertical" :split="false" size="small">
      <ListItem v-for="item in replyComment" :key="item.id" class="reply1">
        <ListItem>
          <Avatar shape="square" size="small" :src="item.avatar"></Avatar>&nbsp;
          <span style="color: #2d9aff;">{{ item.nickname }}&nbsp;</span> 回复:
          &nbsp;<span style="color: #2d9aff;">{{ comment.nickname }}</span>:{{ item.content }}

          <!-- &nbsp;({{item.createTime}}) -->
          <a @click="toParent(comment,item)" style="margin-left: 30px;">
            <Icon type="ios-chatbubbles-outline"/> 回复
          </a>
          <li style="margin-top: 10px;">

          </li>
        </ListItem>
        <div v-if="item.replyComments" class="reply2">
          <reply :replyComment="item.replyComments" :comment='item'
                 v-bind="$attrs" v-on="$listeners"></reply>
        </div>

      </ListItem>
    </List>
  </div>

</template>
<script>

export default {
  name: 'reply',
  props: {
    comment: {},
    replyComment: Array
  },
  methods: {
    // 获取父类的方法
    toParent (comment, item) {
      this.$emit('showCommentInput', comment, item)
    }
  }
}
</script>

<style scoped>
list, listitem {
  display: block;
}

.reply2 {
  margin-left: 0px;
  /*margin-top: 10px;*/
}

.reply1 {
  display: block;
  /* margin-left: 20px; */
  padding-top: 5px;
}

/*        .reply3{
          height: 30px;
         } */
</style>
