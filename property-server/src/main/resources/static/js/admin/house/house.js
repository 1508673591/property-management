$(function () {
	var columns = [

			{ checkbox: true, align: 'center' },
			{ title: '楼宇', field: 'building.buildingName' }, 			
			{ title: '房屋编号', field: 'houseNo' }, 			
			{ title: '用户', field: 'member.realName' }, 			
			{ title: '户型', field: 'houseType' }, 			
			{ title: '面积', field: 'area' }, 			
			{ title: '备注', field: 'remark' }, 			
			{ title: '创建时间', field: 'createTime' }			
]

$("#table").bootstrapTable({
	        url: baseURL + 'house/list',
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
		        	houseNo: vm.q.houseNo
	        	}
	        }
	   });
});
var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		house: {},
		q: {
			houseNo: ''
		},
		buildingList: [],
		memberList: []
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.house = {
					memberId: '',
					buildingId: ''
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
			var url = vm.house.id == null ? "house/save" : "house/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.house),
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
				    url: baseURL + "house/delete",
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
			$.get(baseURL + "house/info/"+id, function(r){
                vm.house = r.house;
            });
		},
		getBuilding: function(){
			$.get(baseURL + "building/listAll", function(r){
                vm.buildingList = r.buildingList;
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
		this.getBuilding();
		this.getMember();
	}
});