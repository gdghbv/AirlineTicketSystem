import request from '@/utils/request'
import { useTokenStore } from '@/stores/token'

export const FlightListService =()=>{
    const tokenStore = useTokenStore()
    // return request.get('/companyView/aircraftList',{headers: {'Authorization': tokenStore.token}})
    //因为在request。js中设置了默认的headers，所以这里可以不用设置headers
    return request.get('/companyView/aircraftList')
}
export const FlightOrderService=(flightID)=>{
    return request.post('/customerView/orderFlight')
}
