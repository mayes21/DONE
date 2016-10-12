$(document).ready(function () {
  var trigger = $('.hamburger'),
      overlay = $('.overlay'),
     isClosed = false;

    trigger.click(function () {
      menu();
    });

    function menu() {

      if (isClosed == true) {
        overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
        isClosed = false;
      } else {
        $(".addTaskForm").hide();
        $(".addTaskLink").show();
        overlay.show();
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
        isClosed = true;
      }
  }

  $('[data-toggle="offcanvas"]').click(function () {
        $('#wrapper').toggleClass('toggled');
  });

  $(function() {
    $.datepicker.setDefaults( $.datepicker.regional[ "" ] );
    $("#datepicker").datepicker($.datepicker.regional["fr"]);
  });

  $(".addTaskLink").click(function() {
      $(".addTaskForm").show();
      $(".addTaskLink").hide();
  });

  $("#cancelAddTask").click(function(e) {
      e.preventDefault();
      $(".addTaskForm").hide();
      $(".addTaskLink").show();
      $(".addTaskForm").find("input[type=text]").val("");
  });

});
