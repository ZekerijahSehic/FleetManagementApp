$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleMovement) {
            $('#idEdit').val(vehicleMovement.id)
            $('#ddlVehicleEdit').val(vehicleMovement.vehicleid);
            $('#ddlLocation1Edit').val(vehicleMovement.locationid1);

            var startDate = vehicleMovement.date1.substr(0,10);
            $('#date1Edit').val(startDate);

            $('#ddlLocation2Edit').val(vehicleMovement.locationid2);

            var endDate = vehicleMovement.date2.substr(0,10);
            $('#date2Edit').val(endDate);

            $('#remarksEdit').val(vehicleMovement.remarks);
        });
        $('#editVehicleMovementModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteVehicleMovementModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleMovement) {
            $('#idDetails').val(vehicleMovement.id);
            $('#ddlVehicleDetails').val(vehicleMovement.vehicleid);
            $('#ddlLocation1Details').val(vehicleMovement.locationid1);

            var startDate = vehicleMovement.date1.substr(0,10);
            $('#date1Details').val(startDate);

            $('#ddlLocation2Details').val(vehicleMovement.locationid2);

            var endDate = vehicleMovement.date2.substr(0,10);
            $('#date2Details').val(endDate);

            $('#remarksDetails').val(vehicleMovement.remarks);

        })
        $('#detailsVehicleMovementModal').modal();
    })

})