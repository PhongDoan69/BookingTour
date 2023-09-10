/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function deleteNews(endpoint) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {

        let request = {
            method: 'DELETE',
            redirect: 'follow'
        };

        fetch(endpoint, request).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống đang có lỗi! Vui lòng quay lại sau!");
        });
    }
}
