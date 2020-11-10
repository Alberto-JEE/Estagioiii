(function($){

$.fn.sweetPages = function(opts){
	
	if(!opts) opts = {};
	
	var resultsPerPage = opts.perPage || 3;
	
	var ul = this;
	var li = ul.find('li');
	
	li.each(function(){
		var el = $(this);
		el.data('height',el.outerHeight(true));
	});
	
	var pagesNumber = Math.ceil(li.length/resultsPerPage);

	if(pagesNumber<2) return this;

	var swControls = $('<div class="swControls">');
	
	for(var i=0;i<pagesNumber;i++)
	{

		li.slice(i*resultsPerPage,(i+1)*resultsPerPage).wrapAll('<div class="swPage" />');

		swControls.append('<a href="" class="swShowPage">'+(i+1)+'</a>');
	}

	ul.append(swControls);
	
	var maxHeight = 0;
	var totalWidth = 0;
	
	var swPage = ul.find('.swPage');
	swPage.each(function(){
		
		var elem = $(this);

		var tmpHeight = 0;
		elem.find('li').each(function(){tmpHeight+=$(this).data('height');});

		if(tmpHeight>maxHeight)
			maxHeight = tmpHeight;

		totalWidth+=elem.outerWidth();
		
		elem.css('float','left').width(ul.width());
	});
	
	swPage.wrapAll('<div class="swSlider" />');
	
	ul.height(maxHeight);
	
	var swSlider = ul.find('.swSlider');
	swSlider.append('<div class="clear" />').width(totalWidth);

	var hyperLinks = ul.find('a.swShowPage');
	
	hyperLinks.click(function(e){
		
		$(this).addClass('active').siblings().removeClass('active');
		
		swSlider.stop().animate({'margin-left':-(parseInt($(this).text())-1)*ul.width()},'slow');
		e.preventDefault();
	});

	hyperLinks.eq(0).addClass('active');

	swControls.css({
		'left':'50%',
		'margin-left':-swControls.width()/2
	});
	
	return this;
	
}})(jQuery);


$(document).ready(function(){

	$('#holder').sweetPages({perPage:3});
	
	var controls = $('.swControls').detach();
	controls.appendTo('#main');
	
});