<template>
  <div class="home-content">
    <iv-row>
      <iv-col :xs="500" :sm="500" :md="500" :lg="500">
        <div class="dev-sign-main ivu-card ivu-card-dis-hover ivu-card-shadow">
          <div class="ivu-card-body">
            <iv-form class="ivu-form ivu-form-label-top">
              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">昵称</label>
                <iv-formItem>
                  <iv-input v-model="username" type="text" placeholder="起一个拉风的名字吧" />
                </iv-formItem>
              </div>

              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">电子邮箱</label>
                <iv-formItem>
                  <iv-input v-model="email" type="text" placeholder="请填写你的电子邮箱">
                    <iv-button slot="append" style="height: 30px" @click="sendEmail">
                      <div class="iconfont icon-youxiang1" style="margin-top: -10px"></div>
                    </iv-button>
                  </iv-input>
                </iv-formItem>
              </div>

              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">密码</label>
                <iv-formItem>
                  <iv-input v-model="password" autocomplete="off" type="password" placeholder="请输入密码"/>
                </iv-formItem>
              </div>

              <div class="ivu-form-item ivu-form-item-required ivu-form-item-error">
                <label class="ivu-form-item-label">验证码</label>
                <iv-formItem>
                  <iv-input v-model="verifyCode" autocomplete="off" placeholder="请输入验证码" style="width: 150px"/>
                  <a style="margin-left:15px " @click="sendEmail">没有收到验证码？再来一条</a>
                </iv-formItem>
              </div>
            </iv-form>

            <div class="dev-sign-main-aside">
              <iv-button class="ivu-btn ivu-btn-success ivu-btn-long ivu-btn-large" @click="register">
                <i class="ivu-icon ivu-icon-md-log-in"></i>
                <span>注册</span>
              </iv-button>

              <div class="dev-sign-main-aside-tip">
                <p>已有有账户？
                  <router-link to="/login">登录</router-link>
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
import { sendRegisterEmail } from '@/api/user'

export default {
  data() {
    return {
      email: '',
      username: '',
      password: '',
      verifyCode: ''
    }
  },
  methods: {
    sendEmail() {
      if (this.email === null || this.email === '') {
        this.$Message.error('请填写邮箱')
        return
      }
      const params = { 'email': this.email }
      sendRegisterEmail(params)
      this.$Message.info('请在 ' + this.email + ' 邮箱下查收验证码')
    },
    register() {
      if (this.form.email === null || this.form.email === '') {
        this.$Message.error('请输入邮箱')
        return
      }
      if (this.form.password === null || this.form.password === '') {
        this.$Message.error('请输入密码')
        return
      }
      if (this.form.code === null || this.form.code === '') {
        this.$Message.error('请输入验证码')
        return
      }
      const params = {
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
