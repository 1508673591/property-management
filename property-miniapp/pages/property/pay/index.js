// pages/property/pay/index.js
const app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    type: 1
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (!app.globalData.token) {
      wx.navigateTo({
        url: '/pages/login/index',
      })
      return;
    }
  },

  typeChange(e){
    this.setData({
      type:  e.detail.value
    })
  },

  bindSave: function(e){
    var that = this;
    var amount = e.detail.value.amount;
    if (amount == '') {
      wx.showModal({
        title: '提示',
        content: '金额不能为空',
        showCancel: false,
        success: function (res) {
        }
      })
    } else {
      wx.request({
        url: app.globalData.domain + "/api/pay/save",
        method: 'POST',
        header: {
          token: app.globalData.token
        },
        data: {
          type: that.data.type,
          amount: amount
        },
        success: function (res) {
          if(res.data.code == 0){
             wx.redirectTo({
               url: '/pages/property/pay-list/index',
             })
          }else{
            wx.showModal({
              title: '提示',
              content: res.data.msg,
              showCancel: false,
              success: function (res) {
              }
            })
          }
          
        },
        fail:function(res){
          console.log(res);
        }
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})