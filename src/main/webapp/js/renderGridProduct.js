$(document).ready(function(){
	getProduct();
});


function getProduct() {
	 $.get("GetProduct", function(data, status) {
		console.log(data);
		var gridProduct = data.map(function (product) {
			return renderProductCard(product);
		});
		$("#gridProduct").html(gridProduct.join(''));
    });
}

function renderProductCard(product) {
	// body...
	var component = '<div class="col-md-3"">'+
						'<div class="productCard">'+
							'<img src="'+product.img+'" alt="'+product.img+'" class="imgProduct">'+
							'<div class="infoCard">'+
								'<div class="nameProduct">'+product.name+'</div>'+
								'<div class="priceProduct"><span class="glyphicon glyphicon-usd"></span>: '+product.price+' VND</div>'+
								'<div class="qualityProduct"><span class=" glyphicon glyphicon-equalizer"></span>: '+product.quatity+'</div>'+
								'<div class="infoProduct">'+product.info+'</div>'+
							'</div>'+
						'</div>'+
					'</div>';
	return component;
}