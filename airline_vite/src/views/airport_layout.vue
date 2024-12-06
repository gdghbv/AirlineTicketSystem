<template>
    <div class="common-layout">
      <el-container class="layout-container">
        <el-header>机场菜单</el-header>
        <el-container>
          <el-aside width="200px">
            <div class="el-aside__logo"></div>
            <!-- element-plus的菜单标签 -->
            <el-menu active-text-color="#ffd04b" background-color="#232323" text-color="#fff" router>
              <el-menu-item index="/airport/flight">
                <el-icon>
                  <Management />
                </el-icon>
                <span>航班管理</span>
              </el-menu-item>
              <el-menu-item index="/airport/info">
                <el-icon>
                  <User />
                </el-icon>
                <span>公司信息</span>
              </el-menu-item>

              <el-menu-item index="/airport/customer">
                <el-icon>
                  <User />
                </el-icon>
                <span>客户信息</span>
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