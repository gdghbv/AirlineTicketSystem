<script setup>
import { ref ,} from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const routesData = ref([{
    "departureTime": "2024年11月11号",
    "departure": "广州",
    "destination": "北京",
    "cabinType": "头等舱",
    "startingAirport": "乐山高机场",
    "destinationAirport": "凯旋机场",
    "aircraftType": "f-1",
    "businessClassSeats": "99",
    "economySeats": "400",
    "boardingGate": "01",
    "tickeID": "1号",
    "price": "1000"

}
]);
const addRoutesData = ref([
    {
        departureTime: '',
        departure: '',
        destination: '',
        cabinType: '',
        startingAirport: '',
        destinationAirport: '',
        aircraftType: '',
        businessClassSeats: '',
        economySeats: '',
        boardingGate: '',
        tickeID: '',
        price: ''

    }
])
const clearData = () => {
    addRoutesData.value = {
        departureTime: '',
        departure: '',
        destination: '',
        cabinType: '',
        startingAirport: '',
        destinationAirport: '',
        aircraftType: '',
        businessClassSeats: '',
        economySeats: '',
        boardingGate: '',
        tickeID: '',
        price: ''
    }
}
const showDialog = (row) => {
    dialogVisible.value=true;
    title.value='编辑航线';
    addRoutesData.value=row;
}

</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
            <span>机场航线信息</span>
            <div class="extra">
                <el-button type="primary" @click="dialogVisible = true; title = '添加航线'; clearData()">添加航线</el-button>
            </div></div>
        </template>
        <el-table :data="routesData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="日期/时间" type="departureTime"></el-table-column>
            <el-table-column label="出发地" prop="departure"></el-table-column>
            <el-table-column label="目的地" prop="destination"></el-table-column>
            <el-table-column label="舱型" prop="cabinType"></el-table-column>
            <el-table-column label="出发机场" prop="startingAirport"></el-table-column>
            <el-table-column label="目标机场" prop="destinationAirport"></el-table-column>
            <el-table-column label="机型" prop="aircraftType"></el-table-column>
            <el-table-column label="商务舱数量" prop="businessClassSeats"></el-table-column>
            <el-table-column label="经济舱数量" prop="economySeats"></el-table-column>
            <el-table-column label="检票口" prop="boardingGate"></el-table-column>
            <el-table-column label="机票编号" prop="tickeID"></el-table-column>
            <el-table-column label="价格" prop="Price"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                <el-button :icon="Delete" circle plain type="danger" @click="routesDeleteService(row)">删除</el-button>
           </template> 
        </el-table-column>
        </el-table>
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addRoutesData" lable-width="100px" style="padding-right: 30px;">
                 <el-form-item label="日期/时间" prop="departureTime">
                    <el-input v-model="addRoutesData.DateTim" placeholder="日期/时间"></el-input>
                 </el-form-item>
                 <el-form-item label="出发地" prop="departure">
                    <el-input v-model="addRoutesData.StartingPoint" placeholder="请输入出发地"></el-input>
                 </el-form-item>
                 <el-form-item label="目的地" prop="destination">
                    <el-input v-model="addRoutesData.destination" placeholder="请输入目的地"></el-input>
                 </el-form-item>
                 <el-form-item label="舱型" prop="cabinType">
                    <el-input v-model="addRoutesData.CabinType" placeholder="请输入舱型"></el-input>
                 </el-form-item>
                 <el-form-item label="出发机场" prop="startingAirport">
                    <el-input v-model="addRoutesData.StartingAirport" placeholder="请输入出发机场"></el-input>
                 </el-form-item>
                 <el-form-item label="目标机场" prop="destinationAirport">
                    <el-input v-model="addRoutesData.DestinationAirport" placeholder="请输入目标机场"></el-input>
                 </el-form-item>
                 <el-form-item label="机型" prop="aircraftType">
                    <el-input v-model="addRoutesData.AircraftType" placeholder="请输入机型"></el-input>
                 </el-form-item>
                 <el-form-item label="商务舱数量" prop="businessClassSeats">
                    <el-input v-model="addRoutesData.businessClassSeats" placeholder="请输入商务舱数量"></el-input>
                 </el-form-item>
                 <el-form-item label="经济舱数量" prop="economySeats">
                    <el-input v-model="addRoutesData.economySeats" placeholder="请输入经济舱数量"></el-input>
                 </el-form-item>
                 <el-form-item label="机票编号" prop="tickeID">
                    <el-input v-model="addRoutesData.companyID" placeholder="请输入机票编号"></el-input>
                 </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title=='添加机票'?addRoutes():updateRoutes()"> 确 定</el-button>
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