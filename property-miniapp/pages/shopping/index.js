var app = getApp()
Page({
  data: {
    currentTpye: 0
  }, 

  onLoad: function (options) {
    // 生命周期函数--监听页面加载
    this.getShopping();
  },
  onReady: function () {
    // 生命周期函数--监听页面初次渲染完成

  },
  onShow: function () {
        

  },

  getShopping: function (){
    wx.showLoading();
    var that = this;
    var postData = {
      token: app.globalData.token,
      status: ''
    };
    wx.request({
      url: app.globalData.domain + '/api/shopping/list',
      header:{

      },
      data: postData,
      success: (res) => {
        wx.hideLoading();
        if (res.data.code == 0) {
          that.setData({
            shoppingList: res.data.shoppingList
          });
        } else {
          this.setData({
            shoppingList: null
          });
        }
      }
    })
  },
  onHide: function () {
    // 生命周期函数--监听页面隐藏

  },
  onUnload: function () {
    // 生命周期函数--监听页面卸载

  },
  onPullDownRefresh: function () {
    // 页面相关事件处理函数--监听用户下拉动作

  },
  onReachBottom: function () {
    // 页面上拉触底事件的处理函数

  },
  bookTap: function (e) {
    console.log("bookTap:" + e.currentTarget.dataset.aid)
    wx.navigateTo({
      url: 'goodspay/goodspay?id=' + e.currentTarget.dataset.aid
    })
  }, 
})