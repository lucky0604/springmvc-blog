/**
 * Created by lucky on 12/6/16.
 */
;$(function() {
    $('#messages li').click(function() {
        $(this).fadeOut();
    });
    setTimeout(function() {
        $('#messages li.error').fadeOut();
        $('#messages li.info').fadeOut();
    }, 3000);
});