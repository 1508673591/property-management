$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '用户', field: 'member.realName' }, 			
			{ title: '车牌号', field: 'carNo' }, 			
			{ title: '汽车品牌', field: 'brand' }, 			
			{ title: '创建时间', field: 'createTime' }			
]

$("#table").bootstrapTable({
	        url: baseURL + 'car/list',
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
		        	carNo: vm.q.carNo
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		car: {},
		q: {
			carNo: ''
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
			vm.car = {
					memberId: ''
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
			var url = vm.car.id == null ? "car/save" : "car/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.car),
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
				    url: baseURL + "car/delete",
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
			$.get(baseURL + "car/info/"+id, function(r){
                vm.car = r.car;
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
		}
	},
	created(){
		this.getMember();
	}
});