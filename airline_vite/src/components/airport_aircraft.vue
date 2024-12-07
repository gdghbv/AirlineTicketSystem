<script setup>

import { ref } from 'vue';


const dialogVisible = ref(false)
const aircraft = ref([{
}
])
const title = ref('')
const addAircraftData = ref({
    aircraftType: '',
    aircraftID: '',
    companyID: ''
})
const clearData = () => {
    addAircraftData.value = {
        aircraftType: '',
        aircraftID: '',
        companyID: ''
    }
}

const showDialog = (row) => {
    dialogVisible.value = true;
    title.value = '编辑飞机起降信息';
    addAircraftData.value = row;
}

</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>飞机起降信息</span>
                <div class="extra">
                    <el-button type="primary"
                        @click="dialogVisible = true; title = '添加分类'; clearData()">添加飞机</el-button>
                </div>
            </div>
        </template>
        <el-table :data="aircraft" style="width: 100%">
            <el-table-column label="序号" width="100" type="index"></el-table-column>
            <el-table-column label="飞机型号" prop="aircraftType"></el-table-column>
            <el-table-column label="飞机编号" prop="aircraftID"></el-table-column>
            <el-table-column label="所属公司代码" prop="companyID"></el-table-column>
            <el-table-column label="操作">
                <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary" @click="showDialog(row)">编辑</el-button>
                    <el-button :icon="Delete" circle plain type="danger" @click="aircraftDelete(row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <!-- 添加飞机的弹窗 -->
        <el-dialog v-model="dialogVisible" :title="title" width="30%">
            <el-form :model="addAircraftData" label-width="100px" style="padding-right: 30px;">
                <el-form-item label="飞机型号" prop="aircraftType">
                    <el-input v-model="addAircraftData.aircraftType" placeholder="请输入飞机型号"></el-input>
                </el-form-item>
                <el-form-item label="飞机编号" prop="aircraftID">
                    <el-input v-model="addAircraftData.aircraftID" placeholder="请输入飞机编号"></el-input>
                </el-form-item>
                <el-form-item label="所属公司代码" prop="companyID">
                    <el-input v-model="addAircraftData.companyID" placeholder="请输入公司代码"></el-input>
                </el-form-item>
            </el-form>
            <template #footer>
                <span class="dialog-footer">
                    <el-button type="primary" @click="title == '添加分类' ? addAircraft() : updateAircraft()">确 定</el-button>
                    <el-button @click="dialogVisible = false">取 消</el-button>
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