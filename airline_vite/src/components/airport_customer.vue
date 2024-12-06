<script setup>
import { ref ,} from 'vue';

const title = ref('');
const dialogVisible = ref(false);

const flight = ref([{

}
]);

const addFlightData = ref([
    {
        citizenID: '',
        name: '',
        phoneNumber: '',
        gender: '',
        points: '',
        email: '',
        password: '',

    }
])
const clearData = () => {
    addFlightData.value = {
        citizenID: '',
        name: '',
        phoneNumber: '',
        gender: '',
        points: '',
        email: '',
        password: '',

    }
}

import { flightListService, flightAddService, flightDeleteService, flightUpdateService } from '@/api/airport_view'
const flightList = async () => {
    let result = await flightListService();
console.log(result);
    flight.value = result.data;
   
}
flightList();
import { ElMessage } from 'element-plus'
const addFlight = async () => {
    let result = await flightAddService(addFlightData.value);
    ElMessage.success(result.msg ? result.msg : '添加成功');
    dialogVisible.value = false;
    flightList();
}
const updateFlight = async () => {
    let result = await flightUpdateService(addFlightData.value);
    ElMessage.success(result.msg ? result.msg : '修改成功');
    dialogVisible.value = false;
    flightList();
}
import { ElMessageBox } from 'element-plus'
const flightDelete = async (row) => {
    ElMessageBox.confirm(
        '你确认要删除该飞机信息吗?',
        '温馨提示',
        {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning',
        }
    )
        .then(async () => {
            //调用接口
            let result = await flightDeleteService(row.flightID);
            ElMessage({
                type: 'success',
                message:  '删除成功',
            })
            //刷新列表
            flightList();
        })
        .catch(() => {
            ElMessage({
                type: 'info',
                message: '用户取消了删除',
            })
        })
}

const showDialog = (row) => {
    dialogVisible.value=true;
    title.value='编辑客户';
    addFlightData.value=row;
}

</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
            <span>客户信息</span>
            <div class="extra">
                <el-button type="primary" @click="dialogVisible = true; title = '添加客户'; clearData()">添加客户</el-button>
            </div></div>
        </template>
        <el-table :data="flight" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="公民身份号码" type="citizenID"></el-table-column>
            <el-table-column label="姓名" prop="name"></el-table-column>
            <el-table-column label="电话号码" prop="phoneNumber"></el-table-column>
            <el-table-column label="性别" prop="gender"></el-table-column>
            <el-table-column label="积分 " prop="points"></el-table-column>
            <el-table-column label="邮箱" prop="email"></el-table-column>
            <el-table-column label="密码" prop="password"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                <el-button :icon="Delete" circle plain type="danger" @click="flightDelete(row)">删除</el-button>
           </template> 
        </el-table-column>
        </el-table>
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addFlightData" lable-width="100px" style="padding-right: 30px;">
                <el-form-item label="公民身份号码" prop="citizenID">
                   <el-input v-model="addFlightData.DateTim" placeholder="请输入公民身份号码"></el-input>
                </el-form-item>
                <el-form-item label="姓名" prop="name">
                   <el-input v-model="addFlightData.StartingPoint" placeholder="请输入姓名"></el-input>
                </el-form-item>
                <el-form-item label="电话号码" prop="phoneNumber">
                   <el-input v-model="addFlightData.destination" placeholder="请输入电话号码"></el-input>
                </el-form-item>
                <el-form-item label="性别" prop="gender">
                   <el-input v-model="addFlightData.StartingAirport" placeholder="请输入性别"></el-input>
                </el-form-item>
                <el-form-item label="积分" prop="points">
                   <el-input v-model="addFlightData.DestinationAirport" placeholder="请输入积分"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-input v-model="addFlightData.SeatNumber" placeholder="请输入邮箱"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                   <el-input v-model="addFlightData.AircraftType" placeholder="请输入密码"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title=='添加客户'?addFlight():updateFlight()"> 确 定</el-button>
                    <el-button @click="dialogVisible = false"> 取 消</el-button>
                </span>
            </template>
        </el-dialog>
    </el-card>
</template>
<style lang="scss" scoped>
.page-container {
    min-height: 100%;
    box-sizing: border-box;

    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
}
</style>