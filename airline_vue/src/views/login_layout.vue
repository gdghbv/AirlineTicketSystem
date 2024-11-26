<script setup>
import {  ref } from "vue";
//记录登录页面的数据
const userData = ref({
  email: "",
  password: "",
  role: "",
});
//记录注册页面的数据
const registerData = ref({
  email: "",
  password: "",
  repassword: "",
  role: "1",
  citizenID: "",
  companyID: "",
});


// 注册函数
import { customerRegisterService } from "@/api/customer";
const register= async()=>{
  let result = await customerRegisterService(registerData.value);
  console.log(result);
  console.log("111");
if (result.code===0){
  alert(result.msg?result.msg:"注册成功");
}else {
  alert("注册失败")
}
}

const checkRePassword = (rule, value, callback) => {
  if (value == "") {
    callback(new Error("请再次输入密码"));
  } else if (value !== registerData.value.password) {
    callback(new Error("两次密码不一样！"));
  } else {
    callback();
  }
};

//设置注册时输入的规则
const registerRules = {
  email: [{ required: true, message: "请输入邮箱", trigger: "blur" }],
  password: [{ required: true, message: "请输入密码", trigger: "blur" }],
  repassword: [{ validator: checkRePassword, trigger: "blur" }],
  role: [{ required: true, message: "请选择要注册的角色", trigger: "blur" }],
};
//设置登录时输入的规则



//注册页面的点击切换事件
const clickChange = async(val) => {
  if (val==1||signUpMode.value==true) {
   registerCustomer.value=true;
   registerCompany.value=false;
   registerAirport.value=false;
   
  } else if (val == 2||signUpMode.value==true) {
    registerCustomer.value=false;
    registerCompany.value=true;
    registerAirport.value=false;
  
  } else if (val == 3||signUpMode.value==true){
    registerCustomer.value=false;
    registerCompany.value=false;
    registerAirport.value=true;
  }
};

// 切换登录/注册模式默认设置为登录页面
const signUpMode = ref(true);

//
const registerCustomer=ref(true);
const registerCompany=ref(false);
const registerAirport=ref(false)
</script>
<template>
  <div class="container" :class="{ 'sign-up-mode': signUpMode }">
    <!-- form表单容器 -->
    <div class="form-container">
      <div class="signin-signup">
        <!--注册表单 -->
        <el-form
          ref="form"
          v-if="!signUpMode"
          :model="registerData"
          :rules="registerRules"
        >
          <el-form-item>
            <h1>注册</h1>
          </el-form-item>
          <el-form-item prop="email">
            <el-input
              prefix-icon="user"
              placeholder="请输入邮箱"
              v-model="registerData.email"
            />
          </el-form-item>
          <el-form-item prop="role">
            <el-radio-group v-model="registerData.role" @change="clickChange">
              <el-radio label="1">客户</el-radio>
              <el-radio label="2">航空公司用户</el-radio>
              <el-radio label="3">机场用户</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item v-show="registerCustomer" prop="citizenID">
            <el-input
              prefix-icon="Id"
              placeholder="请输入身份证号码"
              v-model="registerData.citizenID"
            />
          </el-form-item>
          <el-form-item v-show="registerCompany" prop="companyID">
            <el-input
              prefix-icon="Id"
              placeholder="请输入企业社会统一信用号"
              v-model="registerData.companyId"
            />
          </el-form-item>
          
          <el-form-item prop="password">
            <el-input
              prefix-icon="password"
              type="password"
              show-password
              placeholder="请输入密码"
              v-model="registerData.password"
            />
          </el-form-item>
          <el-form-item prop="repassword">
            <el-input
              prefix-icon="repeat-password"
              type="password"
              show-password
              placeholder="请再次输入密码"
              v-model="registerData.repassword"
              prop="repassword"
            />
          </el-form-item>
          <el-form-item>
            <el-button class="button" type="primary" auto-insert-space @click="register">
              注册
            </el-button>
          </el-form-item>
        </el-form>

        <el-form ref="form" :model="userData" v-if="signUpMode" >
          <el-form-item>
            <h1>登录</h1>
          </el-form-item>
          <el-form-item>
            <el-input
              prefix-icon="user"
              placeholder="请输入用户名"
              v-model="userData.email"
            />
          </el-form-item>
          <el-form-item>
            <el-radio-group v-model="userData.role">
              <el-radio    label="1">机场用户</el-radio>
              <el-radio    label="2">航空公司用户</el-radio>
              <el-radio    label="3">客户</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
            <el-input
              prefix-icon="password"
              type="password"
              show-password
              placeholder="请输入密码"
              v-model="userData.password"
            />
          </el-form-item>
          <el-form-item>
            <el-button class="button" type="primary" auto-insert-space >
              登录
            </el-button>
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
          <h3>民航订票系统用户登录页面</h3>
          <p>没有账号？注册！</p>
          <button @click="signUpMode = false" class="btn transparent">
            切换到注册页面
          </button>
        </div>
        <!-- <img src="@/assets" alt=""> -->
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import url("../assets/login.scss");
</style>
