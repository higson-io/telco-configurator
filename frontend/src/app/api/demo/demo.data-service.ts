import {Observable} from 'rxjs';

export abstract class DemoDataService {

  abstract version(date: string): Observable<void>;


}
