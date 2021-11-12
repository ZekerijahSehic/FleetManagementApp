$('document').ready(function() {

    $('table #editButton').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleMaintenance) {
            $('#idEdit').val(vehicleMaintenance.id);
            $('#ddlVehicleEdit').val(vehicleMaintenance.vehicleid);
            $('#ddlSupplierEdit').val(vehicleMaintenance.supplierid);

            var startDate = vehicleMaintenance.startDate.substr(0,10);
            $('#startDateEdit').val(startDate);

            var endDate = vehicleMaintenance.endDate.substr(0,10);
            $('#endDateEdit').val(endDate);

            $('#priceEdit').val(vehicleMaintenance.price);
            $('#remarksEdit').val(vehicleMaintenance.remarks);
        });
        $('#editVehicleMaintenanceModal').modal();
    })

    $('table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href')
        $('#confirmDeleteButton').attr('href', href)
        $('#deleteVehicleMaintenanceModal').modal()
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleMaintenance) {
            $('#idDetails').val(vehicleMaintenance.id);
            $('#ddlVehicleDetails').val(vehicleMaintenance.vehicleid);
            $('#ddlSupplierDetails').val(vehicleMaintenance.supplierid);

            var startDate = vehicleMaintenance.startDate.substr(0,10);
            $('#startDateDetails').val(startDate);

            var endDate = vehicleMaintenance.endDate.substr(0,10);
            $('#endDateDetails').val(endDate);

            $('#priceDetails').val(vehicleMaintenance.price);
            $('#remarksDetails').val(vehicleMaintenance.remarks);

        })
        $('#detailsVehicleMaintenanceModal').modal();
    })

})