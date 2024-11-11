<template>
    <div class="container" :class="{ 'sign-up-mode': signUpMode }">
      <!-- form表单容器 -->
      <div class="form-container">
        <div class="signin-signup">
          <!-- 登录 -->
          <el-form :model="loginUser"
          label-width="100px"
          class="login-form">
            <el-form-item label="邮箱" prop="email">
         
        </el-form-item>
          </el-form>
          <!-- 注册 -->
          
        </div>
      </div>
      <!-- 左右切换动画 -->
      <div class="panels-container">
        <div class="panel left-panel">
          <div class="content">
            <h3>账号登录</h3>
            <br>
        
            <button @click="signUpMode = !signUpMode" class="btn transparent">
             没有账户？注册！
            </button>
          </div>
          <!-- <img src="@/assets" alt=""> -->
        </div>
        <div class="panel right-panel">
          <div class="content">
            <h3>账号注册</h3>
            <button @click="signUpMode = !signUpMode" class="btn transparent">
              已有账户？登录！
            </button>
          </div>
          <!-- <img src="@/assets" alt=""> -->
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { reactive, ref } from 'vue'
  export default {
    name: 'LoginRegister',
    components: {},
    // Vue3语法糖
    // Vue2是通过data和methods传递数据和方法
    // Vue3将data和methods直接耦合在了一起
    setup() {
      // 登录/注册模式
      const signUpMode = ref(false)

      const loginUser=reactive({
        username: '',
        password: ''
      })
  
      return { signUpMode }
    }
  }
  </script>
 <style scoped>
@import '../../public/css/login.css'</style>