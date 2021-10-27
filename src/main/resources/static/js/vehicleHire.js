$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleHire) {
            $('#idEdit').val(vehicleHire.id);
            $('#ddlVehicleEdit').val(vehicleHire.vehicleid);
            $('#ddlClientEdit').val(vehicleHire.clientid);
            $('#ddlLocationEdit').val(vehicleHire.locationid);

            var dateIn = vehicleHire.dateIn.substr(0,10);
            $('#dateInEdit').val(dateIn);

            var dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateOutEdit').val(dateOut);

            $('#timeOutEdit').val(vehicleHire.timeOut);
            $('#timeInEdit').val(vehicleHire.timeIn);

            $('#priceEdit').val(vehicleHire.price);
            $('#remarksEdit').val(vehicleHire.remarks);
        });
        $('#editVehicleHireModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteVehicleHireModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleHire) {
            $('#idDetails').val(vehicleHire.id);
            $('#ddlVehicleDetails').val(vehicleHire.vehicleid);
            $('#ddlClientDetails').val(vehicleHire.clientid);
            $('#ddlLocationDetails').val(vehicleHire.locationid);

            var dateIn = vehicleHire.dateIn.substr(0,10);
            $('#dateInDetails').val(dateIn);

            var dateOut = vehicleHire.dateOut.substr(0,10);
            $('#dateOutDetails').val(dateOut);

            $('#timeOutDetails').val(vehicleHire.timeOut);
            $('#timeInDetails').val(vehicleHire.timeIn);

            $('#priceDetails').val(vehicleHire.price);
            $('#remarksDetails').val(vehicleHire.remarks);

        })
        $('#detailsVehicleHireModal').modal();
    })

})