function deleteProduct(endpoint) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            console.info(res);
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống đang có lỗi! Vui lòng quay lại sau!");
        });
    }
}

function stringFormat(tourName) {
    var newString;
    if(tourName.length > 15) {
        newString = tourName.splice(15) + "...";
        return newString;
    } else 
        return tourName;
}
