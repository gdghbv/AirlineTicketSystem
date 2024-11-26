import request from '@/utils/request.js'

export const customerRegisterService=(CustomerRegisterData)=>{
    const params=new URLSearchParams();
    for(let key in CustomerRegisterData){
        params.append(key,CustomerRegisterData[key]);
      console.log(key,CustomerRegisterData[key]);
      

    }
    console.log(params.values());
   request.post('/customer/register',CustomerRegisterData);
}