$('#btnDriverProfile').click(function () {
    $('#driverProfile').css({
        'display': 'block'
    });
    $('#driverSchedule').css({
        'display': 'none'
    });
});
$('#btnDriverSchedule').click(function () {
    $('#driverProfile').css({
        'display': 'none'
    });
    $('#driverSchedule').css({
        'display': 'block'
    });
});
