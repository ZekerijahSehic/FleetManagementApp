$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (employeeType){
            $('#idEdit').val(employeeType.id);
            $('#descriptionEdit').val(employeeType.description);
            $('#detailsEdit').val(employeeType.details);
        })
        $('#detailsEmployeeTypeModal').modal();
    })

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteEmployeeTypeModal').modal();
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (employeeType){
            $('#idDetails').val(employeeType.id);
            $('#descriptionDetails').val(employeeType.description);
            $('#detailsDetails').val(employeeType.details);
        })
        $('#detailsEmployeeTypeModal').modal();
    })
})