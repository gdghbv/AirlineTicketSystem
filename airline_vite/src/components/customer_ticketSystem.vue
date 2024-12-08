<script setup>
import { ref ,} from 'vue';

const title = ref('');
const dialogVisible = ref(false);

const flight = ref([{

}
]);

import { ElMessage } from 'element-plus'
const addTicketSystem = async () => {
    let result = await ticketSystemAddService(addAircraftData.value);
    ElMessage.success(result.msg ? result.msg : '下单成功');
    dialogVisible.value = false;
}


const showDialog = (row) => {
    dialogVisible.value=true;
}



</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
            <span>航班信息</span>
            </div>
        </template>
        <el-table :data="flight" style="width: 100%">
            <el-table-column label="序号" type="index"></el-table-column>
            <el-table-column label="日期/时间" type="departureTime"></el-table-column>
            <el-table-column label="出发地" prop="departure"></el-table-column>
            <el-table-column label="目的地" prop="destination"></el-table-column>
            <el-table-column label="出发机场" prop="startingAirport"></el-table-column>
            <el-table-column label="目标机场 " prop="destinationAirport"></el-table-column>
            <el-table-column label="座位数" prop="nemberSeats"></el-table-column>
            <el-table-column label="机型" prop="aircraftType"></el-table-column>
            <el-table-column label="检票口" prop="boardingGate"></el-table-column>
            <el-table-column label="航班编号" prop="flightID"></el-table-column>
            <el-table-column label="价格" prop="Price"></el-table-column>

            <el-table-column label="操作">
                <template #default="{ row }">
                <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">订票</el-button>
           </template> 
        </el-table-column>
        </el-table>

        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <template #footer>
                <span class="dialog-footer">
                    
                    <el-button @click="addTicketSystem = false"> 确 定</el-button>
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