# cloud2021学习的一个过程记录
#订单支付
POST http://localhost:8001/payment/create
Content-Type: application/json

{
  "serial":"aaa210"
}

###
GET http://localhost:8001/payment/get/7
Accept: application/json

###
#获取服务的信息
GET http://localhost:8001/payment/discovery
Accept: application/json

###
#消费者订单调用
GET http://localhost:8080/consumer/payment/create?serial=aaa210_810_1_2
Accept: application/json

<> 2021-01-23T095059.200.json
<> 2021-01-23T095001.400.json

###
GET http://localhost:8080/consumer/payment/get/3
Accept: application/json

<> 2021-01-23T094944.200.json

###
