var divs = $('.header');
$(window).on('scroll', function() {
  var st = $(this).scrollTop();
  divs.css({ 'opacity' : (1 - st/$(window).height()) });
  $('.bodybg').css({ 'opacity' : (st/$(window).height()) });
  $('.bg-faded').css('background', convertHex('#f7f7f9',st/$(window).height()));
  // console.log(st/$(window).height());
});

function convertHex(hex,opacity){
    hex = hex.replace('#','');
    r = parseInt(hex.substring(0,2), 16);
    g = parseInt(hex.substring(2,4), 16);
    b = parseInt(hex.substring(4,6), 16);
    result = 'rgba('+r+','+g+','+b+','+opacity+')';
    return result;
}



function scrollWin() {
  var x = 0;
  var y = $(window).height() - ($(window).height()/100) * 7.5;
  window.scrollTo(x, y);
}

$("h1#headerTitle").fitText(
      1.2, {
          minFontSize: '50px',
          maxFontSize: '75px'
      }
  );

$(function() {
  $('a[href*="#"]:not([href="#"])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 1000);
        return false;
      }
    }
  });
});

// $( document ).ready(function() {
//     $(".pokemon").addClass("img-fluid");
// });
