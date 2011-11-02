package bookclient

class BookstoreController {
    def model
    def view
    def bookstoreService

    def search = {
        execSync {
            model.busy = true
            model.status = ''
            model.results.clear()
        }

        String where = view.choice.selection.actionCommand

        try {
            List results = []
            switch(where) {
                case BookstoreModel.AUTHORS:
                  results = bookstoreService.searchAuthors(model)
                  break
                case BookstoreModel.BOOKS:
                  results = bookstoreService.searchBooks(model)
                  break
            }
            execSync {
                model.status = 
                  "Found ${results.size()} result${results.size() != 1 ? 's': ''}"
                if(results) model.results.addAll(results)
            }
        } finally {
            execAsync { model.busy = false }
        }
    }

    def connect = {
        bookstoreService.populateModel(model)
    }
}
