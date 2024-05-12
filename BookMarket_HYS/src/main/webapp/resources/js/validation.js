function CheckAddBook() {

   console.log('CheckAddBook is called');
   var bookId = document.getElementById("bookId");
   var name = document.getElementById("name");
   var unitPrice = document.getElementById("unitPrice");
   var unitsInStock = document.getElementById("unitsInStock");
   var description = document.getElementById("description");

   if (!check(/^ISBN[0-9]{4,11}$/, bookId, "[도서코드]\nISBN과 숫자를 조합하여 8~15자까지 입력하세요.\n첫 글자는 반드시 ISBN으로 시작하세요"))
      return false;

   if (name.value.length < 4 || name.value.length > 50) {
      alert("[도서명]\n 최소 4자에서 최대 50자까지 입력하세요");
      name.focus();
      return false;
   }

   if (unitPrice.value.length == 0 || isNaN(unitPrice.value)) {
      alert("[가격]\n숫자만 입력하세요");
      unitPrice.focus();
      return false;
   }

   if (unitPrice.value < 0) {
      alert("[가격]\n음수를 입력할 수 없습니다.");
      unitPrice.focus();
      return false;
   }

   if (isNaN(unitsInStock.value)) {
      alert("[재고 수]\n숫자만 입력하세요");
      unitsInStock.focus();
      return false;
   }

   if (description.value.length < 100) {
      alert("[상세설명]\n 최소 100 자 이상 입력하세요");
      description.focus();
      return false;
   }

   function check(regExp, e, msg) {
      if (regExp.test(e.value)) {
         return true;
      }
      alert(msg);
      e.focus();
      return false;
   }

   document.newBook.submit();
}