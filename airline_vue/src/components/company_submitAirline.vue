<script setup>
import { ref ,} from 'vue';
const title = ref('');
const dialogVisible = ref(false);
const routesData = ref([{
    "routeID": "1",
    "aircraftType": "波音747",
    "origin": "北京",
    "destination": "上海",
    "originAirport": "北京首都国际机场",
    "destinationAirport": "上海虹桥国际机场",
    "firstSeats": "100",
    "businessSeats": "50",
    "economySeats": "20",
    "companyID": "1"
}
]);
const addRoutesData = ref([
    {
        routeID: '',
        aircraftType: '',
        origin: '',
        destination: '',
        originAirport: '',
        destinationAirport: '',
        firstSeats: '',
        businessSeats: '',
        economySeats: '',
        companyID: ''
    }
])
const clearData = () => {
    addRoutesData.value = {
        routeID: '',
        aircraftType: '',
        origin: '',
        destination: '',
        originAirport: '',
        destinationAirport: '',
        firstSeats: '',
        businessSeats: '',
        economySeats: '',
        companyID: ''
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
            <span>公司航线信息</span>
            <div class="extra">
                <el-button type="primary" @click="dialogVisible = true; title = '添加航线'; clearData()">添加航线</el-button>
            </div></div>
        </template>
        <el-table :data="routesData" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="航线ID" prop="routeID"></el-table-column>
            <el-table-column label="机型" prop="aircraftType"></el-table-column>
            <el-table-column label="始发地" prop="origin"></el-table-column>
            <el-table-column label="目的地" prop="destination"></el-table-column>
            <el-table-column label="起飞机场" prop="originAirport"></el-table-column>
            <el-table-column label="到达机场" prop="destinationAirport"></el-table-column>
            <el-table-column label="一等座" prop="firstSeats"></el-table-column>
            <el-table-column label="商务座" prop="businessSeats"></el-table-column>
            <el-table-column label="经济舱" prop="economySeats"></el-table-column>
            <el-table-column label="公司ID" prop="companyID"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                <el-button :icon="Delete" circle plain type="danger" @click="routesDeleteService(row)">删除</el-button>
           </template> 
        </el-table-column>
        </el-table>
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addRoutesData" lable-width="100px" style="padding-right: 30px;">
                 <el-form-item label="航线ID" prop="routeID">
                    <el-input v-model="addRoutesData.routeID" placeholder="请输入航线ID"></el-input>
                 </el-form-item>
                 <el-form-item label="机型" prop="aircraftType">
                    <el-input v-model="addRoutesData.aircraftType" placeholder="请输入机型"></el-input>
                 </el-form-item>
                 <el-form-item label="始发地" prop="origin">
                    <el-input v-model="addRoutesData.origin" placeholder="请输入始发地"></el-input>
                 </el-form-item>
                 <el-form-item label="目的地" prop="destination">
                    <el-input v-model="addRoutesData.destination" placeholder="请输入目的地"></el-input>
                 </el-form-item>
                 <el-form-item label="起飞机场" prop="originAirport">
                    <el-input v-model="addRoutesData.originAirport" placeholder="请输入起飞机场"></el-input>
                 </el-form-item>
                 <el-form-item label="到达机场" prop="destinationAirport">
                    <el-input v-model="addRoutesData.destinationAirport" placeholder="请输入到达机场"></el-input>
                 </el-form-item>
                 <el-form-item label="一等座" prop="firstSeats">
                    <el-input v-model="addRoutesData.firstSeats" placeholder="请输入一等座"></el-input>
                 </el-form-item>
                 <el-form-item label="商务座" prop="businessSeats">
                    <el-input v-model="addRoutesData.businessSeats" placeholder="请输入商务座"></el-input>
                 </el-form-item>
                 <el-form-item label="经济舱" prop="economySeats">
                    <el-input v-model="addRoutesData.economySeats" placeholder="请输入经济舱"></el-input>
                 </el-form-item>
                 <el-form-item label="公司ID" prop="companyID">
                    <el-input v-model="addRoutesData.companyID" placeholder="请输入公司ID"></el-input>
                 </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title=='添加航线'?addRoutes():updateRoutes()"> 确 定</el-button>
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