$('document').ready(function (){
    $('table #editButton').on('click', function (event){
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (jobTitle){
            $('#idEdit').val(jobTitle.id);
            $('#descriptionEdit').val(jobTitle.description);
            $('#detailsEdit').val(jobTitle.details);
        })
        $('#editJobTitleModal').modal();
    })

    $('table #deleteButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);
        $('#deleteJobTitleModal').modal();
    })

    $('table #detailsButton').on('click', function (event){
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (jobTitle){
            $('#idDetails').val(jobTitle.id);
            $('#descriptionDetails').val(jobTitle.description);
            $('#detailsDetails').val(jobTitle.details);
        })
        $('#detailsJobTitleModal').modal();
    })
})