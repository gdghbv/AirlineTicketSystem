<template>
  <div class="common-layout">
    <el-container class="layout-container">
      <el-header>航空公司菜单</el-header>
      <el-container>
        <el-aside width="200px">
          <div class="el-aside__logo"></div>
          <!-- element-plus的菜单标签 -->
          <el-menu active-text-color="#ffd04b" background-color="#232323" text-color="#fff" router>
            <el-menu-item index="/article/category">
              <el-icon>
                <Management />
              </el-icon>
              <span>航线提交</span>
            </el-menu-item>
            <el-menu-item index="/article/manage">
              <el-icon>
                <Promotion />
              </el-icon>
              <span>飞机管理</span>
            </el-menu-item>
            <el-menu-item index="/article/info">
              <el-icon>
                <User />
              </el-icon>
              <span>公司信息</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main>
          <div style="width:95%;height :90%; border :1px solid red;">

          </div>
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