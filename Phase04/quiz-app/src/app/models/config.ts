export class Config {
    allowBack: boolean;
    allowNext: boolean;
    allowReview: boolean;
    pageSize: number;
    requiredAll: boolean;

    constructor(data: any) {
        data = data || {};
        this.allowBack = data.allowBack;
        this.allowNext = data.allowNext;
        this.allowReview = data.allowReview;
        this.pageSize = data.pageSize;
        this.requiredAll = data.requiredAll;
    }
}