<template>
    <div class="container" :class="{ 'sign-up-mode': signUpMode }">
        <!-- form表单容器 -->
        <div class="form-container">
            <div class="signin-signup">
                <!--注册表单 -->
                <el-form ref="form" v-if="!signUpMode" :model="registerData">
                    <el-form-item>
                        <h1>注册</h1>
                    </el-form-item>
                    <el-form-item>
                        <el-input prefix-icon="user" placeholder="请输入用户名"  v-model="registerData.username"/>
                    </el-form-item>
                    <el-form-item>
                        <el-radio-group v-model="registerData.role" >
                            <el-radio >机场用户</el-radio>
                            <el-radio >航空公司用户</el-radio>
                            <el-radio >客户</el-radio>
                        </el-radio-group>
                    </el-form-item>
                    <el-form-item>
                        <el-input prefix-icon="password" type="password" show-password placeholder="请输入密码" v-model="registerData.password"/>
                        <el-input prefix-icon="repeat-password" type="password" show-password placeholder="请再次输入密码" v-model="registerData.repassword"/>
                    </el-form-item>
                </el-form>
            </div>
        </div>








        <!-- 左右切换动画 -->
        <div class="panels-container">
            <div class="panel left-panel">
                <div class="content">
                    <h3>民航订票系统用户注册页面</h3>
                    <p>已有账号？登录！</p>
                    <button @click="signUpMode = true" class="btn transparent">
                       切换到登录页面
                    </button>
                </div>
                <!-- <img src="@/assets" alt=""> -->
            </div>
            <div class="panel right-panel">
                <div class="content">
                    <h3>jiachan</h3>
                    <p>Life is but a dream</p>
                    <button @click="signUpMode = false" class="btn transparent">
                        登录
                    </button>
                </div>
                <!-- <img src="@/assets" alt=""> -->
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
const registerData = ref({
    username: '',
    password: '',
    repassword:'',
    role: ''
})

        // 登录/注册模式
        const signUpMode = ref(false)

      
    

</script>


<style lang="scss" scoped>
@import url("../assets/login.scss");
</style>