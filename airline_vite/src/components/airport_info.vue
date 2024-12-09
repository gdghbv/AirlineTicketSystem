<template>
    <div>
      <el-row :gutter="20" style="margin-top:10px;">
        <el-col :span="8">
            <div class="grid-content bg-purple">
                 <el-card class="box-card">
        <div class="clearfix">
          <span>机场信息</span>
        </div>
          <div class="name-role">
          <span class="sender">Admin - {{dataForm?.airportID}}</span>  
        </div>
        <div class="registe-info">
          <span class="registe-info">
            注册时间：
            <li class="fa fa-clock-o"></li>
             2020/4/10 9:40:33
          </span>
        </div>
        <el-divider></el-divider>
        <div class="personal-relation">
        <div class="relation-item">邮箱:  <div style="float: right; padding-right:20px;">{{dataForm?.email}}</div></div>
    </div>
    <div class="personal-relation">
      <div class="relation-item">机场名称:  <div style="float: right; padding-right:20px;">{{data.Form?.airportName}}</div></div> 
    </div>
       <div class="personal-relation">
      <div class="relation-item">机场电话:  <div style="float: right; padding-right:20px;">{{dataForm?.phone}}</div></div>      
    </div>
    <div class="personal-relation">
      <div class="relation-item">机场地址:  <div style="float: right; padding-right:20px;">{{dataForm?.airportAddress}}</div></div>      
    </div>
    
      </el-card>
        </div>
        </el-col>

      </el-row>
    </div>
</template>

<script set up>
import { ref } from 'vue'
const dataForm = ref({
  email: ' ',
  airportName:' ',
  phone: ' ',
  airportAddress: ' ',
  airportID: ' ',

})
import { airportInfoService } from '@/api/airport_view';
const getAirportInfo = async () => {
  const res = await airportInfoService();
  dataForm.value = res.data;
}
dataForm.value = getAirportInfo();
</script>

<style lang="scss" scoped>
//卡片样式
 .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 100%;
  }
//文本样式区
  .name-role {
    font-size: 16px;
    padding: 5px;
   text-align:center;
  }
   .sender{
      text-align:center;
    }
.registe-info{
  text-align: center;
  padding-top:10px;
}
.personal-relation {
  font-size: 16px;
  padding: 0px 5px 15px;
  margin-right: 1px;
    width: 100%
}

.relation-item {
  padding: 12px;
   
}
.dialog-footer{
  padding-top:10px ;
  padding-left: 10%;
}
//布局样式区
   .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
</style>
