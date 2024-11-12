const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave:false,//将一些eslint的警告忽略掉，不进行eslint检测，项目完成后最后再开启eslint检测

})
