Page({
    data:{
      phone_numbers: [
        {
          id:"num-1",
          organization:"广州物协",
          num:"85591048"
        },
        {
          id:"num-2",
          organization:"物业投诉电话",
          num:"12358"
        },
        {
          id:"num-3",
          organization:"公安报警",
          num:"110"
        },{
          id:"num-4",
          organization:"火警",
          num:"119"
        },{
          id:"num-5",
          organization:"救护",
          num:"120"
        },{
          id:"num-6",
          organization:"燃气热线",
          num:"962777"
        },{
          id:"num-7",
          organization:"番禺区派出所",
          num:"020-84768406"
        }]
    },
    call:function(e){
      var phone_num = e.target.dataset.phoneNum;
      wx.makePhoneCall({
        phoneNumber: phone_num
      })
    }
  })
  