

<template>
  <div class="common-layout">
    
    <img src="E:\air\airline_vite\src\assets\蓝天白云.png">
    
    
    
    <el-container class="layout-container">
      <!--左侧菜单---->
      <el-container>
        <el-aside width="200px">
          <div class="el-aside__logo"></div>
          <!-- element-plus的菜单标签 -->
          <!--公司logo-->
          <el-empty
              image="https://ooo.0x0.ooo/2024/12/07/OL0L46.gif"
              description=" "
          />
          
          <el-menu active-text-color="#ffd04b" background-color="#232323" text-color="#fff" router>
            <el-menu-item index="/company/submitAirline">
              <el-icon>
                <Management />
              </el-icon>
              <span>航线提交</span>
            </el-menu-item>
            <el-menu-item index="/company/aircraft">
              <el-icon>
                <Promotion />
              </el-icon>
              <span>飞机管理</span>
            </el-menu-item>
            <el-menu-item index="/company/info">
              <el-icon>
                <User />
              </el-icon>
              <span>公司信息</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
        <router-view></router-view>
          
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style lang="scss" scoped>
.layout-container {
  height: 100vh;

  .el-aside {
    background-color: #232323;

    .el-menu {
      border-right: none;
    }
  }




}
</style>