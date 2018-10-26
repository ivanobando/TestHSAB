$(function(){
	
	//solving the menu active problem
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':	
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#lisProducts').addClass('active');
		break;
	default:
		if(menu == "Home") break;
		$('#lisProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}

	
	//code for jquery table

	var $table = $('#productListTable');
	
	if($table.length){
		
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else{
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products';
		}
		
		//console.log('Inside the Table!');
		$table.DataTable({
			lengthMenu: [[2,5,10,-1],['2 Records','5 Records','10 Records','ALL']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			        {data: 'code'},
//			        {data: 'code',mRender: function(data, type, row){
//			        	return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg"';
//			        }},
			        {data: 'name'},
			        {data: 'brand'},
			        {data: 'unitPrice',mRender: function(data,type, row){ 
			        	return '&#8377; ' + data
			        }},
			        {data: 'quantity'},
			        {data: 'id',bSortable: false, mRender: function (data, type, row){
			        	var str = '';
			        	str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>&#160;';
			        	str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
			        	return str;
			        }}
			        ]
		});
	}
});