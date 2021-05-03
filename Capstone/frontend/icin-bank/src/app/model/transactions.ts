export interface Transactions {
    id: number,
    fromAccountNumber: string,
    toAccountNumber: string,
    fromAccountType: string,
    toAccountType: string,
    transferAmount: number,
    transferType: string,
    transferDate: Date,
    transferStatus: number
}
