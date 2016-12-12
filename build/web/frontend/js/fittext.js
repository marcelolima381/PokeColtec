/*global jQuery */
/*!
* FitText.js 1.2
*
* Copyright 2011, Dave Rupert http://daverupert.com
* Released under the WTFPL license
* http://sam.zoy.org/wtfpl/
*
* Date: Thu May 05 14:23:00 2011 -0600
*/

(function( $ ){

  $.fn.fitText = function( kompressor, options ) {

    // Setup options
    var compressor = kompressor || 1,
        settings = $.extend({
          'minFontSize' : Number.NEGATIVE_INFINITY,
          'maxFontSize' : Number.POSITIVE_INFINITY
        }, options);

    return this.each(function(){

      // Store the object
      var $this = $(this);

      // Resizer() resizes items based on the object width divided by the compressor * 10
      var resizer = function () {
        $this.css('font-size', Math.max(Math.min($this.width() / (compressor*10), parseFloat(settings.maxFontSize)), parseFloat(settings.minFontSize)));
        // var fontSize = $this.css('font-size');
        var el = document.getElementById('headerTitle');
        var style = window.getComputedStyle(el, null).getPropertyValue('font-size');
        var fontSize = parseFloat(style);
        // console.log($this.css('font-size'));
        if (fontSize >= 68 && fontSize <= 75) {
          $("div.header").css('padding-top', "28vh");
          $("#headerButton").css('margin-top', "25vh");
        }
        else if (fontSize >= 61 && fontSize <= 67) {
          $("div.header").css('padding-top', "31vh");
          $("#headerButton").css('margin-top', "23vh");
        }
        else if (fontSize >= 54 && fontSize <= 60) {
          $("div.header").css('padding-top', "32vh");
          $("#headerButton").css('margin-top', "24vh");
        }
        else if (fontSize >= 47 && fontSize <= 53) {
          $("div.header").css('padding-top', "33vh");
          $("#headerButton").css('margin-top', "24vh");
        }
        else if (fontSize >= 40 && fontSize <= 46) {
          $("div.header").css('padding-top', "34vh");
          $("#headerButton").css('margin-top', "26vh");
        }
      };

      // Call once to set.
      resizer();

      // Call on resize. Opera debounces their resize by default.
      $(window).on('resize.fittext orientationchange.fittext', resizer);

    });

  };

})( jQuery );
