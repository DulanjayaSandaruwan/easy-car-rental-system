$('#btnCustProfile').click(function () {
    $('#custProfilePage').css({
        'display': 'block'
    });
    $('#customer_Car_Page').css({
        'display': 'none'
    });
    $('#custOrderPage').css({
        'display': 'none'
    });
    $('#customer_Pay_Page').css({
        'display': 'none'
    });
});
$('#btnCustCars').click(function () {
    $('#custProfilePage').css({
        'display': 'none'
    });
    $('#customer_Car_Page').css({
        'display': 'block'
    });
    $('#custOrderPage').css({
        'display': 'none'
    });
    $('#customer_Pay_Page').css({
        'display': 'none'
    });
});
$('#btnCustOrders').click(function () {
    $('#custProfilePage').css({
        'display': 'none'
    });
    $('#customer_Car_Page').css({
        'display': 'none'
    });
    $('#custOrderPage').css({
        'display': 'block'
    });
    $('#customer_Pay_Page').css({
        'display': 'none'
    });
    getBookingID();
});
$('#btnCustPay').click(function () {
    $('#custProfilePage').css({
        'display': 'none'
    });
    $('#customer_Car_Page').css({
        'display': 'none'
    });
    $('#custOrderPage').css({
        'display': 'none'
    });
    $('#customer_Pay_Page').css({
        'display': 'block'
    });
});
