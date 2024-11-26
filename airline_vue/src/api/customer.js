import request from '@/utils/request.js'

export const customerRegisterService=(CustomerRegisterData)=>{
    const params=new URLSearchParams();
    for(let key in CustomerRegisterData){
        params.append(key,CustomerRegisterData[key]);

    }
   
   return request.post('/customer/register',params);
}