$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '商品编号', field: 'goodsId' },
			{ title: '商品标签', field: 'tag' },
			{ title: '用户', field: 'member.realName' }, 			
			{ title: '图片', field: 'goodsImg' },
		{ title: '商品图片', field: 'picUrl',
			formatter: function (value, row, index) {
				return '<img width="100px" src="'+value+'" />';
			}
		},
		{ title: '价格', field: 'goodsPrice' },
			{ title: '商品详情', field: 'goodsDesc' },
			{ title: '创建时间', field: 'createTime' }			
]

$("#table").bootstrapTable({
	        url: baseURL + 'shopping/list',
	        cache: false,
	        striped: true,
	        pagination: true,
	        pageSize: 10,
	        pageNumber: 1,
	        sidePagination: 'server',
	        pageList: [10, 25, 50],
	        columns: columns,
	        queryParams: function (params) {
	        	return {
		        	page: params.offset / 10 + 1,
		        	limit: params.limit,
					goodsId: vm.q.goodsId
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		shopping: { picUrl:"" },
		q: {
			goodsId: ''
		},
		memberList: []
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.shopping = {
					memberId: '',
					goodsId: '',
					picUrl:""
			};
		},
		update: function (event) {
			var id = getSelectedVal("id");
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			if(vm.validator()){
				return;
			}

			var url = vm.shopping.id == null ? "shopping/save" : "shopping/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.shopping),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedVals("id");
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "shopping/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "shopping/info/"+id, function(r){
                vm.shopping = r.shopping;
            });
		},
		getMember: function(){
			$.get(baseURL + "member/listAll", function(r){
                vm.memberList = r.memberList;
            });
		},
		reload: function (event) {
			vm.showList = true;
			$('#table').bootstrapTable('refreshOptions',  {pageNumber: 1});
		},
		validator: function () {
			if(isBlank(vm.shopping.picUrl)){
				alert("请选择图片");
				return true;
			}
		}
	},
	created(){
		this.getMember();
	}
});