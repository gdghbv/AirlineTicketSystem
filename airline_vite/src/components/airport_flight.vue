<script setup>
import { ref ,} from 'vue';

const title = ref('');
const dialogVisible = ref(false);

const flight = ref([{

}
]);

const addFlightData = ref([
    {
        departureTime: '',
        departure: '',
        destination: '',
        startingAirport: '',
        destinationAirport: '',
        nemberSeats: '',
        aircraftType: '',
        boardingGate: '',
        flightID: '',
        price: ''

    }
])
const clearData = () => {
    addFlightData.value = {
        departureTime: '',
        departure: '',
        destination: '',
        startingAirport: '',
        destinationAirport: '',
        nemberSeats: '',
        aircraftType: '',
        boardingGate: '',
        flightID: '',
        price: ''
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
    title.value='编辑航班';
    addFlightData.value=row;
}

</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
            <span>机场航班信息</span>
            <div class="extra">
                <el-button type="primary" @click="dialogVisible = true; title = '添加航班'; clearData()">添加航班</el-button>
            </div></div>
        </template>
        <el-table :data="flight" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="日期/时间" type="departureTime"></el-table-column>
            <el-table-column label="出发地" prop="departure"></el-table-column>
            <el-table-column label="目的地" prop="destination"></el-table-column>
            <el-table-column label="出发机场" prop="startingAirport"></el-table-column>
            <el-table-column label="目标机场" prop="destinationAirport"></el-table-column>
            <el-table-column label="座位数" prop="nemberSeats"></el-table-column>
            <el-table-column label="机型" prop="aircraftType"></el-table-column>
            <el-table-column label="检票口" prop="boardingGate"></el-table-column>
            <el-table-column label="航班编号" prop="flightID"></el-table-column>
            <el-table-column label="价格" prop="Price"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                <el-button :icon="Delete" circle plain type="danger" @click="flightDelete(row)">删除</el-button>
           </template> 
        </el-table-column>
        </el-table>
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addFlightData" lable-width="100px" style="padding-right: 30px;">
                <el-form-item label="日期/时间" prop="departureTime">
                   <el-input v-model="addFlightData.DateTim" placeholder="日期/时间"></el-input>
                </el-form-item>
                <el-form-item label="出发地" prop="departure">
                   <el-input v-model="addFlightData.StartingPoint" placeholder="请输入出发地"></el-input>
                </el-form-item>
                <el-form-item label="目的地" prop="destination">
                   <el-input v-model="addFlightData.destination" placeholder="请输入目的地"></el-input>
                </el-form-item>
                <el-form-item label="出发机场" prop="startingAirport">
                   <el-input v-model="addFlightData.StartingAirport" placeholder="请输入出发机场"></el-input>
                </el-form-item>
                <el-form-item label="目标机场" prop="destinationAirport">
                   <el-input v-model="addFlightData.DestinationAirport" placeholder="请输入目标机场"></el-input>
                </el-form-item>
                <el-form-item label="座位数" prop="nemberSeats">
                    <el-input v-model="addFlightData.SeatNumber" placeholder="请输入座位数"></el-input>
                </el-form-item>
                <el-form-item label="机型" prop="aircraftType">
                   <el-input v-model="addFlightData.AircraftType" placeholder="请输入机型"></el-input>
                </el-form-item>
                <el-form-item label="航班编号" prop="flightID">
                   <el-input v-model="addFlightData.companyID" placeholder="请输入航班编号"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title=='添加航班'?addFlight():updateFlight()"> 确 定</el-button>
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