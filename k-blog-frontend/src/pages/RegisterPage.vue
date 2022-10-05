<template>
  <div class="home-content">
    <iv-row>
      <iv-col :xs="500" :sm="500" :md="500" :lg="500">
        <div class="dev-sign-main ivu-card ivu-card-dis-hover ivu-card-shadow"><!----> <!---->
          <div class="ivu-card-body">
            <iv-form autocomplete="off" class="ivu-form ivu-form-label-top" ref="registForm" :model="form"
                     @keydown.enter.native="handleSubmit"
            >

              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">昵称</label>
                <iv-formItem prop="name"><!----> <!---->
                  <iv-input type="text" placeholder="起一个拉风的名字吧" v-model="form.name">
                  </iv-input>
                </iv-formItem>
              </div>
              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">电子邮箱</label>
                <iv-formItem prop="userName"><!----> <!---->
                  <iv-input type="text" placeholder="请填写你的电子邮箱" v-model="form.userName">
                    <iv-button style="height: 30px" slot="append" @click="ToEmail">
                      <div class="iconfont icon-youxiang1" style="margin-top: -10px"></div>
                    </iv-button>
                  </iv-input>
                </iv-formItem>
              </div>
              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">密码</label>
                <iv-formItem prop="password"><!---->
                  <iv-input autocomplete="off" type="password" v-model="form.password" placeholder="请输入密码"/>
                </iv-formItem>
              </div>
              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">验证码</label>
                <iv-formItem prop="code">
                  <iv-input autocomplete="off" v-model="form.code" placeholder="请输入验证码" style="width: 150px"/>
                  <a @click="ToEmail" style="margin-left:15px "> 没有收到验证码？再来一条</a>
                </iv-formItem>
              </div>
            </iv-form>
            <div class="dev-sign-main-aside">
              <iv-button class="ivu-btn ivu-btn-success ivu-btn-long ivu-btn-large" @click="regist"><!---->
                <i class="ivu-icon ivu-icon-md-log-in"></i>
                <span>注册</span>
              </iv-button>
              <span class="ivu-input-prefix"> <i class="ivu-icon ivu-icon-ios-mail-outline"></i></span>
              <div class="dev-sign-main-aside-tip">
                <!--<p><a href="/recover" class="">忘记密码？</a></p>-->
                <p>已有有账户？
                  <router-link to="/login" class="">登录</router-link>
                </p>
              </div>
            </div>
          </div>
        </div>
      </iv-col>
    </iv-row>
  </div>
</template>

<script type="text/ecmascript-6">

export default {
  name: 'registForm',
  data() {
    return {
      form: {
        userName: '',
        password: '',
        name: '',
        code: ''
      }
    }
  },
  computed: {
    rules() {
      return {
        userName: this.form.userNameRules,
        password: this.form.passwordRules,
        code: this.form.codeRules,
        name: this.form.nameRules
      }
    }
  },
  methods: {
    ToEmail() {
      // alert("请注意去你的邮箱查收验证码哦");
      if (this.form.userName === null || this.form.userName === '') {
        this.$Message.error('请填写你的邮箱哦！')
        return
      }
      alert('请在你的' + this.form.userName + '的邮箱下查收验证码哦')
      let params = {
        username: this.form.userName
      }
      this.$http({
        url: this.$http.adornUrl('/login/sendOutEmail'),
        method: 'post',
        data: this.$https.adornDatas(params)
      }).then(({ data }) => {
        //console.log(JSON.stringify(data))
        if (data && data.code === 0) {
          this.articleList = data.data.list
          this.total = data.data.total
        }
      })
    },
    regist() {
      // alert("请注意去你的邮箱查收验证码哦");
      if (this.form.userName === null || this.form.userName === '') {
        this.$Message.error('请输入你的邮箱哦！')
        return
      }
      if (this.form.password === null || this.form.password === '') {
        this.$Message.error('请输入你的密码哦！')
        return
      }
      if (this.form.code === null || this.form.code === '') {
        this.$Message.error('请输入验证码哦！')
        return
      }
      let params = {
        username: this.form.userName,
        password: this.form.password,
        code: this.form.code,
        name: this.form.name
      }
      this.$http({
        url: this.$http.adornUrl('/register'),
        method: 'post',
        data: this.$https.adornDatas(params)
      }).then(({ data }) => {
        console.log(JSON.stringify(data))
        if (data && data.status === 0) {
          this.$Message.success('注册成功，请移步登录页面登录！')
        } else {
          this.$Message.error(data.errorMsg)
        }
      })
    },

    handleSubmit() {
      this.$refs.registForm.validate((valid) => {
        if (valid) {
          this.$emit('on-success-valid', {
            userName: this.form.userName,
            password: this.form.password
          })
        }
      })
    }
  }
}
</script>

<style lang="stylus" type="text/stylus" rel="stylesheet/stylus">
@import "../common/stylus/theme.styl";

.home-content
  width auto
  min-height calc(100vh - 108px)
  @media only screen and (max-width: 768px)
    margin 5px 5px 0 5px
  @media screen and (min-width: 768px)
    margin 10px 10px 0 10px
  @media screen and (min-width: 992px)
    margin 15px 35px 0 35px
  @media screen and (min-width: 1200px)
    width 1200px
    margin 15px auto 0
    margin-bottom 200px

  .layout-left, .layout-right
    padding 0
    @media only screen and (max-width: 768px)
      padding 0
    @media screen and (min-width: 768px)
      padding 0
    @media screen and (min-width: 992px)
      padding 0 10px
    @media screen and (min-width: 1200px)
      padding 0 10px

.dev-sign-main {
  width: 400px;
  margin: 50px auto;
  padding: 0 16px;
}

.ivu-card-shadow {
  box-shadow: 0 1px 1px 0 rgba(0, 0, 0, .1);
}

.ivu-card {
  background: #FAFAFA;
  border-radius: 4px;
  font-size: 14px;
  position: relative;
  transition: all .2s ease-in-out;
}
</style>
