$(function () {
	var columns = [
			{field: 'selectItem', radio: true},
			{ title: '栏目名称', field: 'columnName' }, 			
			{ title: '状态', field: 'status', formatter: function(row, index){
       			return row.status == 1 ? '<span class="label label-success">显示</span>' : '<span class="label label-warning">隐藏</span>';
       		}},
			{ title: '排序', field: 'sort' }		
	];

	var table = new TreeTable(Column.id, baseURL + "column/list", columns);
    table.setExpandColumn(1);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("parentId");
    table.setExpandAll(false);
    table.init();
    Column.table = table;
});

var Column = {
	    id: "table",
	    table: null,
	    layerIndex: -1
	};

function getId () {
    var selected = $('#table').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}

var vm = new Vue({
	el:'#app',
	data:{
		showList: true,
		title: null,
		parentColumns: [],
		column: {
			parentId: 0
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.column = {
				parentId: 0,
				status: 1
			};
		},
		update: function (event) {
			var id = this.getColumnId();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		getColumnId: function() {
		    var selected = $('#table').bootstrapTreeTable('getSelections');
		    if (selected.length == 0) {
		        alert("请选择一条记录");
		        return false;
		    } else {
		        return selected[0].id;
		    }
		},
		saveOrUpdate: function (event) {
			var url = vm.column.id == null ? "column/save" : "column/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.column),
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
			var id = getId();
            if(id == null){
                return ;
            }
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "column/delete",
				    data: "id=" + id,
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
			$.get(baseURL + "column/info/"+id, function(r){
                vm.column = r.column;
            });
		},
		getParentColumns: function(){
			$.get(baseURL + "column/list",{"parentId": 0}, function(r){
                vm.parentColumns = r;
            });
		},
		reload: function (event) {
			vm.showList = true;
			Column.table.refresh();
		}
	},
	created: function(){
		this.getParentColumns();
	}
});