function invokeService(type,data,url,success)
{
    if (type === "post") {
        $.ajax({
            url: url,
            type: type,
            async: true,
            data: JSON.stringify(data),
            datatype: "json",
            contentType: "application/json",
            error: function () {
            },
            success: success
        })
    }

}