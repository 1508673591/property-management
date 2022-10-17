const app = getApp()

Page({
  data: {
    useTime: 0,
    surplusTime: 0,
    isSignIn: false,
    list: [
      { "name": "我的信息", "url": "/pages/my/info/index" },
      { "name": "我的房屋", "url": "/pages/property/house/index" },
      { "name": "我的车辆", "url": "/pages/property/car/index" },
      { "name": "我的缴费", "url": "/pages/property/pay-list/index" },
      { "name": "我的报修", "url": "/pages/repair/publish-mine/index" }
    ]
  },

  onLoad() {

  },

  logout(){
    app.globalData.token = null
    app.globalData.userInfo = null
    this.setData({
      member: null
    })
  },


  tabNav: function(e){
    var url = e.currentTarget.dataset.url;
    wx.navigateTo({
      url: url,
    })
  },

  onShow() {
    if (!app.globalData.token) {
      return;
    }

    this.getMember();
  },

  getMember: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/member/info',
      data: {
        token: app.globalData.token
      },
      success: function (res) {
        if (res.data.code == 0) {
          that.setData({
            member: res.data.member
          })
        }
      }
    })
  },

  onShareAppMessage: function () {
    var path = '/pages/in/index';
    if (app.globalData.distributor) {
      path = path + "?distributor=" + app.globalData.distributor;
    }
    return {
      title: wx.getStorageSync('storeName'),
      path: path,
      imageUrl: app.globalData.domain + '/images/share-bill.jpg',
      success: function (res) {
        // 转发成功
      },
      fail: function (res) {
        // 转发失败
      }
    }
  },
  
  login: function(){
    wx.navigateTo({
      url: '/pages/login/index',
    })
  }

})