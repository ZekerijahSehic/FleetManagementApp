$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (vehicleStatus){
            $('#idEdit').val(vehicleStatus.id);
            $('#descriptionEdit').val(vehicleStatus.description);
            $('#detailsEdit').val(vehicleStatus.details);
        })
        $('#editVehicleStatusModal').modal();
    })

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteVehicleStatusModal').modal();
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (vehicleStatus){
            $('#idDetails').val(vehicleStatus.id);
            $('#descriptionDetails').val(vehicleStatus.description);
            $('#detailsDetails').val(vehicleStatus.details);
        })
        $('#detailsVehicleStatusModal').modal();
    })
})