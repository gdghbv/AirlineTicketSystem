import request from '@/utils/request.js'

export const customerRegisterService=(registerData)=>{
    const params=new URLSearchParams();
    for(let key in registerData){
        params.append(key,registerData[key]);
       console.log(key,registerData[key]);
       console.log(params);

    }
   
   request.post('/customer/register',registerData);
}